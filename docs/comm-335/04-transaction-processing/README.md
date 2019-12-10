---
sidebar: auto
---

# Transaction Processing

Computing method that divides work into individual, indivisible operations called **transactions**.

Transaction processing -> processing of ==everyday business transactions==.

* A sequence of systematic operations applied to a collection of data to generate useful information.

## Data Processing Application

Consist of either *activities* or *statuses*:

* Activity: Transactions -> Action documents/activity summaries
* Status: Master files -> Updated master files/status reports

Three types of time delays:

* Input delay
* Processing delay
* Output delay

## Real-Time and Batch Processing

* Batch -> Transactions are accumulated before they are processed, then processed together
  * Efficient for large volume of transactions
  * Efficient use of resources
* Real-time -> Transactions processed as they come, one at a time

### Batch Processing

* **Sequential** -> Transactions are sorted in order of master file.
* **Random** -> Transactions are processed in random order.

Batch systems are generally:

* Easy to control
* Safe
* Economic for large transaction volumes
* Disadvantages
  * Outdated information
  * Potential inconsistencies

### Real-Time Systems

Events are processed immediately -> transaction is completed before the next event can occur.

**Controls** include transaction logs and journals -> for safety/security/audit trail.

* Advantages
  * Good timeliness of information
  * Immediate response
  * Errors can be immediately captured
* Disadvantages
  * Sensitive to input errors (assuming no validation)
  * Control/safety issues
  * Complexity
  * Need for dedicated resources

Most information systems consist of ==both real-time and batch components==.

### Updating

* Modify existing records
  * Change numeric field
  * Replace a value with a new value
  * Add group of fields
  * Delete group of fields
* Add new records
* Delete existing records

**Sequential Batch Updates** -> batch of update transactions processed together.

* Efficient if large portion of file is processed
* Safe -> two versions of master file created (before and after)
* Lack of "currency" of master files -> i.e. they can be outdated
* Unnecessary when small portion of file is processed

**Random Batch Updates** -> batch of transactions processed together, in random order.
