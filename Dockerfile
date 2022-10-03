From openjdk:16
copy target/InventorySupplierService-0.0.1-SNAPSHOT.jar InventorySupplierService-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","InventorySupplierService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8093
