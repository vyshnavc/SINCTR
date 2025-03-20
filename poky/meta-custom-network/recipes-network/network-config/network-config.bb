SUMMARY = "Custom Network Configuration"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://NetworkManager.conf file://static-eth0.nmconnection"

DEPENDS = "networkmanager"

S = "${WORKDIR}/sources-unpack"

do_install() {
    install -d ${D}/etc/NetworkManager
    install -m 0644 ${S}/NetworkManager.conf ${D}/etc/NetworkManager/NetworkManager.conf
    install -d ${D}/etc/NetworkManager/system-connections
    install -m 0600 ${S}/static-eth0.nmconnection ${D}/etc/NetworkManager/system-connections/static-eth0.nmconnection
}

FILES:${PN} += "/etc/NetworkManager/NetworkManager.conf"
FILES:${PN} += "/etc/NetworkManager/system-connections/static-eth0.nmconnection"

