package com.example.adminapp;

public class ItemModel {

        String Id,ItemName,ItemIMage;

        public ItemModel() {
        }

        public String getItemIMage() {
            return ItemIMage;
        }

        public void setItemIMage(String itemIMage) {
            ItemIMage = itemIMage;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String itemName) {
            ItemName = itemName;
        }

        public ItemModel(String id, String itemName,String itemIMage) {
            Id = id;
            ItemIMage = itemIMage;
            ItemName = itemName;
        }
    }

