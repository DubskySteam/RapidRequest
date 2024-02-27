plugins {
    id("java")
    id("maven-publish")
    id("net.thebugmc.gradle.sonatype-central-portal-publisher") version "1.1.1"
}

group = "dev.dubsky"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

signing {
    useGpgCmd()
}

centralPortal {
    pom {
        name = "RapidRequest"
        description = "A small and lightweight library to make api requests easier"
        url = "https://github.com/DubskySteam/RapidRequest"
        packaging = "jar"

        licenses {
            license {
                name = "GNU Lesser General Public License v3.0"
                url = "https://www.gnu.org/licenses/lgpl-3.0.html"
            }
        }

        developers {
            developer {
                id = "dubskysteam"
                name = "DubskySteam"
                email = "admin@dubsky.dev"
            }
        }

        scm {
            connection = "scm:git:git://github.com/dubskysteam/rapidrequest.git"
            developerConnection = "scm:git:ssh://github.com/dubskysteam/rapidrequest.git"
            url = "https://github.com/dubskysteam/rapidrequest"
        }
    }
}