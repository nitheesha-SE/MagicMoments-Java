# Configure the Azure Provider
provider "azurerm" {}

variable "prefix" {
  default = "paul"
}

resource "azurerm_resource_group" "ifttt" {
  name     = "${var.prefix}-resources"
  location = "West US 2"
}
