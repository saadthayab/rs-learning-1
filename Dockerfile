#
# Set a variable that can be used in all stages.
#
ARG BUILD_HOME=/SaadRestAutomation1

#
# Gradle image for the build stage.
#
FROM gradle:jdk13 as build-image

#
# Set the working directory.
#
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

#
# Copy the Gradle , source code into the build container.
#
COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src

# Build the application.

RUN gradle clean build test

