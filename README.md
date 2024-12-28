# Form Creator

the controller, service and repository packge was built initialy using AI and then refactored or modified to work properly.

### Notes:
this project has a lot to do, a must have which is not implemented in current project is the validation process of requests. For now, there is no special validation mechanism so much invalid data can be inserted into the system.
some examples are: default value of each field-type must be an appropriate type, for example the default string value for a number field-type should be parsable to int and etc.

The other important missing feature is that each field type should have a metadata value which might be stored as a byte array in our database so to be used to fill required data for each field-type.
