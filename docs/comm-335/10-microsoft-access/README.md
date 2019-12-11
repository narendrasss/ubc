---
sidebar: auto
---

# Microsoft Access

## Creating Tables

### Steps

1. Go to design view
2. Save table name with `tbl` prefix
3. Set field names and adjust options
   1. Data type -> Type of this field
   2. Field size -> Maximum size of field
   3. Format -> How the field should be presented
   4. Validation rule -> Limit possible field inputs
   5. Validation text -> Text to show if validation fails
4. Set primary key -> Select field and press primary key button top left

### Questions

1. Select multiple fields (with shift key) then press primary key button
2. No -> `MemberNo` in `tblReservation` is a foreign key, so it has to correspond with a member in `tblCustomer`. Data type should be `Number`.
3. `Long Integer` has a higher allowed max value. For non-integer numbers, `Double` should be used instead.

## Creating Relationships and Importing Data

### Create Relationships

1. Database Tools -> Relationships
2. Drag tables from left sidebar to main window
3. Drag PK from "many" side to "one" side
   1. Enforce referential integrity and cascade update/delete

**Questions**

1. Cascade update related fields -> Update changes to all foreign keys referencing the primary key
2. Cascade delete related fields -> Delete all related records if PK record is deleted

## Combobox and Two-Level Subforms

1. No control source -> unbound because not tied to a field in any table
2. Row source -> data for the list options
3. `MemberNo` indicates form what it should show

## Sample Questions

2a. Using macros:

1. Create -> Macro -> Show all actions
2. `SetValue` in "Add New Action" dropdown
3. Set `Item` to `DateIn`
4. Set `Expression` to `[DateOut] + 3`
5. Save macro
6. Open form
7. In `After Update` event of `CopyNo` combobox, select the macro you just saved

2b. Using macros:

1. Create -> Macro -> Show all actions
2. `If` in "Add New Action" dropdown
3. Set expression to `Weekday([DateOut], 3) = 1`
4. Inside the `If`, add new `If` action
5. Set expression to `[Format] = "DVD"`