load("//tools/base/bazel:jvm_import.bzl", "jvm_import")
load("//tools/adt/idea/studio:studio.bzl", "intellij_plugin_import", "intellij_platform_import", "intellij_platform")
load("//prebuilts/studio/intellij-sdk:AI/spec.bzl", "SPEC")

package(default_visibility = ["//visibility:public"])

intellij_platform(
    name = "studio-sdk",
    src = "AI",
    spec = SPEC,
)

java_import(
    name = "studio-sdk-impl",
    jars = glob(["AI/linux/android-studio/lib/*.jar","AI/linux/android-studio/plugins/java/lib/*.jar"],
                ["AI/linux/android-studio/lib/annotations-java5.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.java",
    target_dir = "java",
    exports = [":com.intellij.java-lib"],
)

jvm_import(
    name = "com.intellij.java-lib",
    jars = glob(["AI/linux/android-studio/plugins/java/lib/*.jar"]),
)

intellij_plugin_import(
    name = "intellij.jvm.analysis.impl",
    target_dir = "java",
    exports = [":intellij.jvm-lib"],
)
intellij_plugin_import(
    name = "intellij.java.vcs",
    target_dir = "java",
    exports = [":intellij.jvm-lib"],
)
intellij_plugin_import(
    name = "intellij.java.featuresTrainer",
    target_dir = "java",
    exports = [":intellij.jvm-lib"],
)
intellij_plugin_import(
    name = "intellij.java.structuralSearch",
    target_dir = "java",
    exports = [":intellij.jvm-lib"],
)
intellij_plugin_import(
    name = "intellij.java.unscramble",
    target_dir = "java",
    exports = [":intellij.jvm-lib"],
)

jvm_import(
    name = "intellij.jvm-lib",
    jars = glob(["AI/linux/android-studio/plugins/java/lib/modules/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.java-i18n",
    target_dir = "java-i18n",
    exports = [":com.intellij.java-i18n-lib"],
)

jvm_import(
    name = "com.intellij.java-i18n-lib",
    jars = glob(["AI/linux/android-studio/plugins/java-i18n/lib/*.jar"]),
)

intellij_plugin_import(
    name = "Coverage",
    target_dir = "java-coverage",
    exports = [":com.intellij.java-coverage-lib"],
)

jvm_import(
    name = "com.intellij.java-coverage-lib",
    jars = glob(["AI/linux/android-studio/plugins/java-coverage/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.java.ide",
    target_dir = "java-ide-customization",
    exports = [":com.intellij.java-ide-lib"],
)

jvm_import(
    name = "com.intellij.java-ide-lib",
    jars = glob(["AI/linux/android-studio/plugins/java-ide-customization/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.jetbrains.performancePlugin",
    target_dir = "performancePlugin",
    exports = [":com.jetbrains.performancePlugin-lib"],
)

jvm_import(
    name = "com.jetbrains.performancePlugin-lib",
    jars = glob(["AI/linux/android-studio/plugins/performanceTesting/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.intellij.groovy",
    target_dir = "Groovy",
    exports = [":studio-sdk-plugin-Groovy-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-Groovy",
    target_dir = "Groovy",
    exports = [":studio-sdk-plugin-Groovy-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-Groovy-lib",
    jars = glob(["AI/linux/android-studio/plugins/Groovy/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.jetbrains.kotlin",
    target_dir = "Kotlin",
    exports = [":studio-sdk-plugin-Kotlin-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-Kotlin",
    target_dir = "Kotlin",
    exports = [":studio-sdk-plugin-Kotlin-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-Kotlin-lib",
    jars = glob(["AI/linux/android-studio/plugins/Kotlin/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.toml.lang",
    target_dir = "toml",
    exports = [":studio-sdk-plugin-toml-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-toml",
    target_dir = "toml",
    exports = [":studio-sdk-plugin-toml-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-toml-lib",
    jars = glob(["AI/linux/android-studio/plugins/toml/lib/*.jar"]),
)

intellij_plugin_import(
    name = "Git4Idea",
    target_dir = "git4idea",
    exports = [":studio-sdk-plugin-git4idea-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-git4idea",
    target_dir = "git4idea",
    exports = [":studio-sdk-plugin-git4idea-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-git4idea-lib",
    jars = glob(["AI/linux/android-studio/plugins/vcs-git/lib/*.jar"]),
)

intellij_plugin_import(
    name = "intellij.webp",
    target_dir = "webp",
    exports = [":studio-sdk-plugin-webp-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-webp",
    target_dir = "webp",
    exports = [":studio-sdk-plugin-webp-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-webp-lib",
    jars = glob(["AI/linux/android-studio/plugins/webp/lib/*.jar"])
)

intellij_plugin_import(
    name = "JUnit",
    target_dir = "junit",
    exports = [":studio-sdk-plugin-junit-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-junit",
    target_dir = "junit",
    exports = [":studio-sdk-plugin-junit-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-junit-lib",
    jars = glob(["AI/linux/android-studio/plugins/junit/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.jetbrains.plugins.gradle",
    target_dir = "org.jetbrains.plugins.gradle",
    exports = [":org.jetbrains.plugins.gradle-lib"],
)

jvm_import(
    name = "org.jetbrains.plugins.gradle-lib",
    jars = glob(["AI/linux/android-studio/plugins/gradle-java/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.gradle",
    target_dir = "gradle",
    exports = [":studio-sdk-plugin-gradle-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-gradle",
    target_dir = "gradle",
    exports = [":studio-sdk-plugin-gradle-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-gradle-lib",
    jars = glob(["AI/linux/android-studio/plugins/gradle/lib/*.jar"]),
)

intellij_plugin_import(
    name = "studio-sdk-plugin-gradle-java",
    target_dir = "gradle-java",
    exports = [":studio-sdk-plugin-gradle-java-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-gradle-java-lib",
    jars = glob(["AI/linux/android-studio/plugins/gradle-java/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.platform.images",
    target_dir = "platform-images",
    exports = [":studio-sdk-plugin-platform-images-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-platform-images",
    target_dir = "platform-images",
    exports = [":studio-sdk-plugin-platform-images-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-platform-images-lib",
    jars = glob(["AI/linux/android-studio/plugins/platform-images/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.properties",
    target_dir = "properties",
    exports = [":studio-sdk-plugin-properties-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-properties-lib",
    jars = glob(["AI/linux/android-studio/plugins/properties/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.intellij.intelliLang",
    target_dir = "IntelliLang",
    exports = [":studio-sdk-plugin-IntelliLang-lib"],
)

intellij_plugin_import(
    name = "studio-sdk-plugin-IntelliLang",
    target_dir = "IntelliLang",
    exports = [":studio-sdk-plugin-IntelliLang-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-IntelliLang-lib",
    jars = glob(["AI/linux/android-studio/plugins/platform-langInjection/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.modules.json",
    target_dir = "json",
    exports = [":studio-sdk-plugin-json-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-json-lib",
    jars = glob(["AI/linux/android-studio/plugins/json/lib/*.jar"]),
)

intellij_plugin_import(
    name = "org.editorconfig.editorconfigjetbrains",
    target_dir = "editorconfig",
    exports = [":studio-sdk-plugin-editorconfig-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-editorconfig-lib",
    jars = glob(["AI/linux/android-studio/plugins/editorconfig/lib/*.jar"]),
)

intellij_plugin_import(
    name = "com.intellij.turboComplete",
    target_dir = "turboComplete",
    exports = [":studio-sdk-plugin-turboComplete-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-turboComplete-lib",
    jars = glob(["AI/linux/android-studio/plugins/turboComplete/lib/turboComplete.jar"]),
)

intellij_plugin_import(
    name = "intellij.turboComplete.languages.kotlin",
    target_dir = "turboComplete",
    exports = [":studio-sdk-plugin-turboComplete-lib-modules"],
)

jvm_import(
    name = "studio-sdk-plugin-turboComplete-lib-modules",
    jars = glob(["AI/linux/android-studio/plugins/turboComplete/lib/modules/*.jar"]),
)


intellij_plugin_import(
    name = "studio-sdk-test-frameworkxx",
    target_dir = "testFramework",
    exports = [":studio-sdk-plugin-testFramework-lib"],
)

jvm_import(
    name = "studio-sdk-plugin-testFramework-lib",
    jars = glob(["AI/linux/android-studio/lib/testFramework.jar"]),
)

intellij_plugin_import(
    name = "intellij.platform.vcs.impl",
    target_dir = "intellij.platform.vcs.impl",
    exports = [":intellij.platform.vcs.impl-lib"],
)

jvm_import(
    name = "intellij.platform.vcs.impl-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.vcs.impl.jar"]),
)

intellij_plugin_import(
    name = "intellij.platform.vcs.dvcs.impl",
    target_dir = "intellij.platform.vcs.dvcs.impl",
    exports = [":intellij.platform.vcs.dvcs.impl-lib"],
)

jvm_import(
    name = "intellij.platform.vcs.dvcs.impl-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.vcs.dvcs.impl.jar"]),
)

intellij_plugin_import(
    name = "intellij.platform.vcs.log.impl",
    target_dir = "intellij.platform.vcs.log.impl",
    exports = [":intellij.platform.vcs.log.impl-lib"],
)

jvm_import(
    name = "intellij.platform.vcs.log.impl-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.vcs.log.impl.jar"]),
)

intellij_plugin_import(
    name = "intellij.platform.lvcs.impl",
    target_dir = "intellij.platform.lvcs.impl",
    exports = [":intellij.platform.lvcs.impl-lib"],
)

jvm_import(
    name = "intellij.platform.lvcs.impl-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.lvcs.impl.jar"]),
)

intellij_plugin_import(
    name = "intellij.libraries.grpc",
    target_dir = "intellij.libraries.grpc",
    exports = [":com.jetbrains.intellij.libraries.grpc-lib"],
)

jvm_import(
    name = "com.jetbrains.intellij.libraries.grpc-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.grpc.jar"]),
)

intellij_plugin_import(
    name = "intellij.libraries.grpc.netty.shaded",
    target_dir = "intellij.libraries.grpc.netty.shaded",
    exports = [":intellij.libraries.grpc.netty.shaded-lib"],
)

jvm_import(
    name = "intellij.libraries.grpc.netty.shaded-lib",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.grpc.netty.shaded.jar"]),
)

java_import(
    name = "intellij.libraries.ktor.client",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.ktor.client.jar"]),
)

java_import(
    name = "intellij.libraries.ktor.client.cio",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.ktor.client.cio.jar"]),
)

java_import(
    name = "intellij.libraries.microba",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.microba.jar"]),
)

java_import(
    name = "intellij.libraries.skiko",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.libraries.skiko.jar"]),
)

java_import(
    name = "intellij.platform.clouds",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.clouds.jar"]),
)

java_import(
    name = "intellij.platform.collaborationTools",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.collaborationTools.jar"]),
)

java_import(
    name = "intellij.platform.compose",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.compose.jar"]),
)

java_import(
    name = "intellij.platform.coverage",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.coverage.jar"]),
)

java_import(
    name = "intellij.platform.coverage.agent",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.coverage.agent.jar"]),
)

java_import(
    name = "intellij.platform.debugger.impl.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.debugger.impl.backend.jar"]),
)

java_import(
    name = "intellij.platform.debugger.impl.frontend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.debugger.impl.frontend.jar"]),
)

java_import(
    name = "intellij.platform.diagnostic.freezeAnalyzer",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.diagnostic.freezeAnalyzer.jar"]),
)

java_import(
    name = "intellij.platform.diagnostic.freezes",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.diagnostic.freezes.jar"]),
)

java_import(
    name = "intellij.platform.execution.dashboard",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.execution.dashboard.jar"]),
)

java_import(
    name = "intellij.platform.execution.serviceView",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.execution.serviceView.jar"]),
)

java_import(
    name = "intellij.platform.frontend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.frontend.jar"]),
)

java_import(
    name = "intellij.platform.images.backend.svg",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.images.backend.svg.jar"]),
)

java_import(
    name = "intellij.platform.images.copyrigh",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.images.copyrigh.jar"]),
)

java_import(
    name = "intellij.platform.inline.completion",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.inline.completion.jar"]),
)

java_import(
    name = "intellij.platform.kernel.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.kernel.backend.jar"]),
)
java_import(
    name = "intellij.platform.navbar",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.navbar.jar"]),
)

java_import(
    name = "intellij.platform.navbar.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.navbar.backend.jar"]),
)

java_import(
    name = "intellij.platform.navbar.frontend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.navbar.frontend.jar"]),
)
java_import(
    name = "intellij.platform.navbar.monolith",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.navbar.monolith.jar"]),
)

java_import(
    name = "intellij.platform.progress.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.progress.backend.jar"]),
)

java_import(
    name = "intellij.platform.project.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.project.backend.jar"]),
)
java_import(
    name = "intellij.platform.rpc.backend",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.rpc.backend.jar"]),
)

java_import(
    name = "intellij.platform.settings.local",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.settings.local.jar"]),
)

java_import(
    name = "intellij.platform.smRunner.vcs",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.smRunner.vcs.jar"]),
)

java_import(
    name = "intellij.settingsSync.core",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.settingsSync.core.jar"]),
)

java_import(
    name = "intellij.smart.update",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.smart.update.jar"]),
)

java_import(
    name = "org.editorconfig.editorconfigjetbrain",
    jars = glob(["AI/linux/android-studio/plugins/editorconfig/lib/*.jar"]),
)

java_import(
    name = "org.intellij.plugins.markdown",
    jars = glob(["AI/linux/android-studio/plugins/markdown/lib/*.jar"]),
)

java_import(
    name = "intellij.markdown.compose.preview",
    jars = glob(["AI/linux/android-studio/plugins/markdown/lib/modules/*.jar"]),
)

java_import(
    name = "org.jetbrains.idea.reposearch",
    jars = glob(["AI/linux/android-studio/plugins/repository-search/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.idea.maven.model",
    jars = glob(["AI/linux/android-studio/plugins/maven-model/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.idea.maven.server.api",
    jars = glob(["AI/linux/android-studio/plugins/maven-server/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.debugger.streams",
    jars = glob(["AI/linux/android-studio/plugins/java-debugger-streams/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.java.decompiler",
    jars = glob(["AI/linux/android-studio/plugins/java-decompiler/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.plugins.github",
    jars = glob(["AI/linux/android-studio/plugins/vcs-github-community/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.plugins.gitlab",
    jars = glob(["AI/linux/android-studio/plugins/vcs-gitlab/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.plugins.terminal",
    jars = glob(["AI/linux/android-studio/plugins/terminal/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.plugins.textmate",
    jars = glob(["AI/linux/android-studio/plugins/textmate/lib/*.jar"]),
)

java_import(
    name = "org.jetbrains.plugins.yaml",
    jars = glob(["AI/linux/android-studio/plugins/yaml/lib/*.jar"]),
)

java_import(
    name = "DevKit",
    jars = glob(["AI/linux/android-studio/plugins/devkit/lib/*.jar"]),
)

java_import(
    name = "HtmlTools",
    jars = glob(["AI/linux/android-studio/plugins/html-tools/lib/*.jar"]),
)

java_import(
    name = "TestNG-J",
    jars = glob(["AI/linux/android-studio/plugins/testng/lib/*.jar"]),
)

java_import(
    name = "intellij.platform.images.copyright",
    jars = glob(["AI/linux/android-studio/lib/modules/intellij.platform.images.copyright.jar"]),
)

filegroup(
    name = "product-info",
    srcs =  glob(["AI/linux/android-studio/product-info.json"]),
    visibility = ["//visibility:public"],
)

filegroup(
    name = "vm-options",
    srcs = glob(["AI/linux/android-studio/bin/studio64.vmoptions"]),
    visibility = ["//visibility:public"],
)
