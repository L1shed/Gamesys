plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
}

repositories {
    mavenCentral()
    maven("https://maven.enginehub.org/repo/")
    maven("https://repo.codemc.io/repository/maven-public/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.onarandombox.com/content/groups/public/")
}

dependencies {
    implementation("fr.mrmicky", "fastboard", "2.0.1")
    compileOnly("org.jetbrains.kotlin", "kotlin-stdlib", "1.8.21")
    compileOnly("io.papermc.paper", "paper-api", "1.20.2-R0.1-SNAPSHOT")
    compileOnly("com.sk89q.worldedit", "worldedit-core", "7.3.0-SNAPSHOT")
    compileOnly("com.sk89q.worldedit", "worldedit-bukkit", "7.3.0-SNAPSHOT")
    compileOnly("com.fastasyncworldedit","FastAsyncWorldEdit-Core","2.9.0")
    compileOnly("com.onarandombox.multiversecore", "Multiverse-Core", "4.3.12")
    compileOnly("com.gmail.filoghost.holographicdisplays", "holographicdisplays-api", "2.4.0")
    compileOnly("com.mojang","authlib","3.16.29")
    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<Jar> {
    version = "1.0-SNAPSHOT"
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
