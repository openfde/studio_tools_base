#!/bin/bash

# Android Studio ARM64 一键编译脚本
# 基于 Android Studio 2024.3.2 编译说明

set -e

# 配置变量
export STUDIO_VERSION="2024.3.2"
export STUDIO_DIR=$(pwd)

# 颜色输出函数
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

log_info() { echo -e "${BLUE}[INFO]${NC} $1"; }
log_success() { echo -e "${GREEN}[SUCCESS]${NC} $1"; }
log_warning() { echo -e "${YELLOW}[WARNING]${NC} $1"; }
log_error() { echo -e "${RED}[ERROR]${NC} $1"; }

# 检查环境
check_environment() {
    log_info "检查编译环境..."
    
    # 检查架构
    if [ "$(uname -m)" != "aarch64" ]; then
        log_warning "当前架构不是 aarch64，建议在 ARM64 机器上编译"
    fi
    
    # 检查磁盘空间
    local available_space=$(df /home | awk 'NR==2 {print $4}')
    if [ "$available_space" -lt 200000000 ]; then
        log_error "磁盘空间不足，需要至少 200GB 可用空间"
        exit 1
    fi
    
    # 检查内存
    local total_mem=$(free -g | awk 'NR==2 {print $2}')
    if [ "$total_mem" -lt 12 ]; then
        log_warning "内存可能不足，建议 16GB 或以上内存"
    fi
}

# 应用补丁
apply_studio_patches() {
    log_info "应用 Android Studio 补丁..."
    
    cd "$STUDIO_DIR"
    if [ ! -f "tools/replace_intellij.sh" ]; then
        cd "$STUDIO_DIR/android_studio-patches/studio-$STUDIO_VERSION-patch"
        chmod +x apply_patch.sh
        ./apply_patch.sh "$STUDIO_DIR"

        log_success "Android Studio 补丁合并成功"
    else
        log_success "Android Studio 补丁已合并"
    fi
}

# 编译 Android Studio
build_android_studio() {
    log_info "开始编译 Android Studio..."

    cd "$STUDIO_DIR"
    
    # 第一步：编译android studio基础包
    log_info "步骤 1: 编译android studio基础包"
    ./tools/idea/build_studio.sh
    
    # 第二步：编译 artifacts 组件
    log_info "步骤 2: 编译 artifacts 组件"
    if [ ! -d "$STUDIO_DIR/prebuilts/studio/intellij-sdk/AI" ]; then
        mkdir -p $STUDIO_DIR/prebuilts/studio/intellij-sdk/AI
        tools/adt/idea/studio/update_sdk.py --path tools/idea/out/studio/dist

        cp $STUDIO_DIR/android_studio-patches/studio-2024.3.2-patch/prebuilts/studio/intellij-sdk/BUILD \
            $STUDIO_DIR/prebuilts/studio/intellij-sdk/
    fi

    tools/base/bazel/bazel build tools/adt/idea/android:artifacts
    
    # 第三步：编译 Android Studio插件
    log_info "步骤 3: 编译 Android Studio插件"
    tools/base/bazel/bazel build tools/adt/idea/studio:android-studio
    
    log_success "Android Studio 编译完成！"
}

# 主函数
main() {
    log_info "开始 Android Studio ARM64 一键编译流程"
    log_info "Android Studio 目录: $STUDIO_DIR"

    # 执行各个步骤
    check_environment

    apply_studio_patches

    build_android_studio

    log_success "编译成功: $STUDIO_DIR/bazel-bin/tools/adt/idea/studio/android-studio.linux.zip"
}

# 显示使用说明
show_usage() {
    echo "Android Studio ARM64 一键编译脚本"
    echo "用法: $0 [选项]"
    echo ""
    echo "选项:"
    echo "  -h, --help     显示此帮助信息"
    echo ""
    echo "示例:"
    echo "  $0                      # 完整编译"
}

# 解析命令行参数
while [[ $# -gt 0 ]]; do
    case $1 in
        -h|--help)
            show_usage
            exit 0
            ;;
        *)
            log_error "未知参数: $1"
            show_usage
            exit 1
            ;;
    esac
done

main