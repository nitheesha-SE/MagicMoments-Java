output "source_control" {
  value = "${azurerm_app_service.ifttt.source_control}"
}

output "site_credential" {
  value = "${azurerm_app_service.ifttt.site_credential}"
}

output "default_site_hostname" {
  value = "${azurerm_app_service.ifttt.default_site_hostname}"
}

