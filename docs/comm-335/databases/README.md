---
sidebar: auto
---

# Databases

## Database Concepts

A database is an organized collection of logically related data.

Databases allow secure storage of data for an enterprise. Two main types -> **internal** and **external**.

### Internal Databases

* Operational databases
  * Databases used in business operations
* Data warehouse
  * Data not used for routine business activities
  * Contains data collected from variety of sources

### External Databases

* External to an organization
* Typically accessed over the internet

**Database administrator** is the person in charge of managing the internal databases of an organization.

Key terms:

* Field -> A single attribute
* Record -> A logical grouping of related fields
* Table -> A logical grouping of related records

## Database Design

### Integrity

Integrity -> database must have **accurate, valid, and complete** data.

* **Entity** integrity -> Each record must have a unique identifier (i.e. primary key). No two records in the same table can have the same primary key.
* **Primary key** integrity -> Primary key value cannot be empty (null)
* **Domain** integrity -> The field values must be from a finite domain (e.g. a Date field should have a date, and not just a random number)
* **Referential** integrity -> Data referenced and stored across tables must be consistent across the database

### Anomalies

* **Deletion** anomaly -> Deleting one record removes information about other records
* **Update** anomaly -> Updating one field requires updating multiple records
* **Insertion** anomaly -> A field cannot be inserted into the database without the presence of other fields. In the slide example, we cannot add a new customer who has yet to place an order.
