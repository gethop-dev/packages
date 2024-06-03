FROM node:16-bookworm

ENV BINARIES_INSTALL_PATH=/usr/local/bin
ENV BOOT_AS_ROOT=yes
ENV BOOT_VERSION=2.8.2
WORKDIR /build

RUN set -eux; \
    apt-get update && \
    apt-get install -y --no-install-recommends \
    default-jdk webpack && \
    curl -sL -o "${BINARIES_INSTALL_PATH}/boot" "https://github.com/boot-clj/boot-bin/releases/download/latest/boot.sh" && \
    chmod 755 "${BINARIES_INSTALL_PATH}/boot" && \
    boot

COPY . /build
