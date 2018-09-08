resource "random_id" "server" {
  keepers = {
    azi_id = 1
  }

  byte_length = 8
}

resource "azurerm_app_service_plan" "ifttt" {
  name                = "some-app-service-plan"
  location            = "${azurerm_resource_group.ifttt.location}"
  resource_group_name = "${azurerm_resource_group.ifttt.name}"

  sku {
    tier = "Standard"
    size = "S1"
  }
}

resource "azurerm_app_service" "ifttt" {
  name                = "${random_id.server.hex}"
  location            = "${azurerm_resource_group.ifttt.location}"
  resource_group_name = "${azurerm_resource_group.ifttt.name}"
  app_service_plan_id = "${azurerm_app_service_plan.ifttt.id}"

  site_config {
    java_version           = "1.8"
    java_container         = "TOMCAT"
    java_container_version = "8.5.31"
    scm_type               = "LocalGit"
  }
}