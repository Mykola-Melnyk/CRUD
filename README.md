# Zoola-Database-CRUD
<h3>This work introduces servlets to manage your database. You can use servlets to create, read, update, and delete files.
You must also be logged in to perform all these actions.</h3>

In order to perform authorization you need to go to <strong>/login</strong> endpoint and send your login and password in the body using <strong>POST</strong> request.
In case of successful authorization the user will see a message confirming the login.

![image](https://user-images.githubusercontent.com/59668952/186394134-da95e41e-ebd4-4abc-886e-e2c7681cd3e7.png)

You also have the opportunity to make sure that your data has been saved in the session. There is a <strong>/myAccount</strong> endpoint for this. Going there you will just see the data you specified when you logged in.

![image](https://user-images.githubusercontent.com/59668952/186394298-88a77df2-afd0-4cb5-83da-d60ddb129017.png)


To see a list of existing files, you can go to the following path: <strong>/tables</strong>

![image](https://user-images.githubusercontent.com/59668952/186394426-9149b939-35d5-4f88-8267-ac06f6aebe45.png)

If you want to see the content of a file, specify its path after <strong>table/</strong> (e.g. <strong>/table/names</strong>) and perform a <strong>GET</strong> request.

![image](https://user-images.githubusercontent.com/59668952/186394535-c7d7cf8a-8843-42b4-b882-e1269573c7f5.png)

To create a new file, specify its name after <strong>/table</strong> (<strong>/table/{tableName}</strong>) and make a <strong>POST</strong> request.

![image](https://user-images.githubusercontent.com/59668952/186394642-6930cd81-b7e0-490f-97db-563cad7085f1.png)

Now in <strong>/tables</strong> we can see a new file:

![image](https://user-images.githubusercontent.com/59668952/186395192-69c9d0c7-8fdc-4e35-98c6-0afd99c8e7bc.png)


To update the contents of a file, make a <strong>PUT</strong> request to the appropriate path (just like in the previous cases <strong>/table/{tableName}</strong>) and pass the content into the body.

![image](https://user-images.githubusercontent.com/59668952/186394909-af5e75ad-ac69-43bd-8ae9-664a10e7643d.png)

Now we see that our file has been updated:

![image](https://user-images.githubusercontent.com/59668952/186395313-c8f93e2e-2a9a-49d8-bd25-a4a457d789e6.png)


To delete a file, perform a <strong>DELETE</strong> request on the corresponding path.

![image](https://user-images.githubusercontent.com/59668952/186395560-6a0a5339-0c39-486a-8cdc-a3d9e1033056.png)

..and our file disappeared from the file list!

![image](https://user-images.githubusercontent.com/59668952/186395593-56a6ab70-f9db-4f36-9516-a5097d8a297b.png)
