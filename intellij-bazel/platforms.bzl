"""
This file is used to add new intellij platforms to the bazel build.
Here's how to add support:
The URLs have to point to full IDEs, wile there are some versions
of the IDEs inhttps://www.jetbrains.com/intellij-repository
they do not contain the bundled JBRs. These IDEs are used to run
integration tests, so they have to be fully functional. This means are
not able to compile against snapshot builds that have not been released.

To calculate the sha256 download the file and run sha256sum on it.
"""

load("//tools/base/intellij-bazel:intellij.bzl", "local_platform", "remote_platform", "setup_platforms")

def setup_intellij_platforms():
    setup_platforms([
        # For AOSP we switch to a "remote" IntelliJ distribution, since our forked prebuilts
        # at prebuilts/studio/intellij-sdk are not yet available in AOSP. This remote distribution
        # does not contain our IntelliJ patches, but that is OK (even preferred) for the
        # JetBrains/android use case. Note: the 'plugins' must be specified explicitly for
        # remote platforms, unlike for local platforms. Probably this could be simplified.
        remote_platform(
            name = "studio-sdk",
            url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/241.15989.150/ideaIC-241.15989.150.zip",
            sha256 = "910a9c8161d8c3729aa30db17edcc1295ab9d8565d60cd1f0b44884824d7c9c2",
            plugins = [
                "Coverage",
                "Git4Idea",
                "HtmlTools",
                "JUnit",
                "Subversion",
                "TestNG-J",
                "com.intellij.completion.ml.ranking",
                "com.intellij.configurationScript",
                "com.intellij.copyright",
                "com.intellij.dev",
                "com.intellij.gradle",
                "com.intellij.java",
                "com.intellij.java-i18n",
                "com.intellij.java.ide",
                "com.intellij.platform.images",
                "com.intellij.plugins.eclipsekeymap",
                "com.intellij.plugins.netbeanskeymap",
                "com.intellij.plugins.visualstudiokeymap",
                "com.intellij.properties",
                "com.intellij.rml.dfa",
                "com.intellij.tasks",
                "com.intellij.turboComplete",
                "com.jetbrains.performancePlugin",
                "com.jetbrains.sh",
                "hg4idea",
                "intellij.webp",
                "org.editorconfig.editorconfigjetbrains",
                "org.intellij.groovy",
                "org.intellij.intelliLang",
                "org.intellij.plugins.markdown",
                "org.jetbrains.debugger.streams",
                "org.jetbrains.idea.maven.model",
                "org.jetbrains.idea.maven.server.api",
                "org.jetbrains.idea.reposearch",
                "org.jetbrains.java.decompiler",
                "org.jetbrains.kotlin",
                "org.jetbrains.plugins.clangConfig",
                "org.jetbrains.plugins.clangFormat",
                "org.jetbrains.plugins.github",
                "org.jetbrains.plugins.gitlab",
                "org.jetbrains.plugins.gradle",
                "org.jetbrains.plugins.terminal",
                "org.jetbrains.plugins.textmate",
                "org.jetbrains.plugins.yaml",
                "org.toml.lang",
            ],
        ),
        remote_platform(
            name = "intellij_ce_2024_1",
            url = "https://download.jetbrains.com/idea/ideaIC-2024.1.4.tar.gz",
            sha256 = "7d5e4cdb5a7cb1c376ca66957481350571561edadc3f45e6fce422e14af0fc16",
            top_level_dir = "idea-IC-241.18034.62",
        ),
        remote_platform(
            name = "intellij_ce_2024_2",
            url = "https://download.jetbrains.com/idea/ideaIC-2024.2.1.tar.gz",
            sha256 = "781cc03526d5811061c6ffd211942698b3d18ed2f055a04f384956686a7aa0a6",
            top_level_dir = "idea-IC-242.21829.142",
        ),
        remote_platform(
            name = "intellij_ce_2024_3",
            url = "https://download.jetbrains.com/idea/ideaIC-2024.3.1.1.tar.gz",
            sha256 = "b183b126de2cd457475eea184874b5da2fa33ba5ae2ff874bdc8c1d534156428",
            top_level_dir = "idea-IC-243.22562.218",
        ),
    ])
