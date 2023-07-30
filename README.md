<h1>Clothes Billing System</h1>

<p>A Java-based Inventory Management System using Java, MySQL, and Swing.</p>

<h2>Table of Contents</h2>

<ol>
  <li><a href="#description">Description</a></li>
  <li><a href="#features">Features</a></li>
  <li><a href="#technologies-used">Technologies Used</a></li>
  <li><a href="#database-schema">Database Schema</a></li>
  <li><a href="#installation">Installation</a></li>
  <li><a href="#usage">Usage</a></li>
  <li><a href="#screenshots">Screenshots</a></li>
  <li><a href="#contributing">Contributing</a></li>
  <li><a href="#license">License</a></li>
</ol>

<h2 id="description">Description</h2>

<p>This project is an Clothes Billing Appliation developed in Java that provides functionalities for both administrators and employees. It uses Java, MySQL, and Swing for the graphical user interface. The system allows admins to manage items and employees, while employees can generate bills for customers and store billing data into the database.</p>

<h2 id="features">Features</h2>

<ul>
  <li><strong>Admin Module:</strong>
    <ul>
      <li>Register and manage admin data.</li>
      <li>Add, update, and delete items for men, children, and women categories.</li>
      <li>Add and remove employees.</li>
    </ul>
  </li>
  <li><strong>Employee Module:</strong>
    <ul>
      <li>Register and manage employee data.</li>
      <li>Generate bills for customers and store billing data.</li>
    </ul>
  </li>
  
</ul>

<h2 id="technologies-used">Technologies Used</h2>

<ul>
  <li>Java</li>
  <li>MySQL</li>
  <li>Swing (GUI Framework)</li>
</ul>

<h2 id="database-schema">Database Schema</h2>

<p>The database schema consists of the following tables with primary key and unique key constraints:</p>

<ul>
  <li>admin table:
    <ul>
      <li>admin_id (Primary Key)</li>
      <li>username</li>
      <li>password (Unique Key)</li>
      <li>name</li>
      <li>email</li>
      <li>phone_no</li>
    </ul>
  </li>
  <li>employee table:
    <ul>
      <li>emp_id (Primary Key)</li>
      <li>username </li>
      <li>password (Unique Key)</li>
      <li>name</li>
      <li>email</li>
      <li>phone_no</li>
    </ul>
  </li>
  <li>men table:
    <ul>
      <li>item_id (Primary Key)</li>
      <li>name</li>
      <li>price</li>
      <li>quantity</li>
    </ul>
  </li>
  <li>children table:
    <ul>
      <li>item_id</li>
      <li>name</li>
      <li>price</li>
      <li>quantity</li>
    </ul>
  </li>
  <li>women table:
    <ul>
      <li>item_id</li>
      <li>name</li>
      <li>price</li>
      <li>quantity</li>
    </ul>
  </li>
  <li>customer table:
    <ul>
      <li>customer_phone (unique Key)</li>
      <li>name</li>
      <li>email</li>
     
    </ul>
  </li>
  <li>customerbilling table:
    <ul>
      <li>billing_id (Primary Key)</li>
      <li>customer_id (Foreign Key referencing customer table)</li>
      <li>date</li>
      <li>total_amount</li>
    </ul>
  </li>
</ul>

<h2 id="installation">Installation</h2>

<ol>
  <li>Clone the repository to your local machine.</li>
  <li>Ensure you have Java Development Kit (JDK) installed.</li>
  <li>Set up a MySQL database and import the provided schema and tables.</li>
  <li>Update the database connection settings in the project to match your MySQL database.</li>
</ol>

<h2 id="usage">Usage</h2>

<ol>
  <li>Run the application.</li>
  <li>Choose the appropriate user type (admin or employee) and log in with valid credentials.</li>
  <li>Use the admin module to manage items, employees, and admin data.</li>
  <li>Use the employee module to generate bills for customers and store billing data.</li>
 
</ol>

<h2 id="screenshots">Screenshots</h2>
 <img src="https://user-images.githubusercontent.com/100610668/186716058-a11f0e20-40d9-4917-929f-91592c4be6e7.png"/>

<img src="https://user-images.githubusercontent.com/100610668/186716156-9b1ccf0d-0bc0-4242-8677-45d98e645acd.png"/>

<img src="https://user-images.githubusercontent.com/100610668/186716267-664a425a-4b78-4f8a-92bf-9aeea2109ae4.png"/>

<img src="https://user-images.githubusercontent.com/100610668/186716317-d0f5b82b-ec3f-402a-9d9d-e8108e1fdbcd.png"/>

<img src="https://user-images.githubusercontent.com/100610668/186716376-ec23b776-4f43-47ed-ba6a-9b75b4996c6d.png"/>
<img src="https://user-images.githubusercontent.com/100610668/186716521-1991237d-d2c7-46b0-a0ca-7925087311b8.png"/>

<img src="https://user-images.githubusercontent.com/100610668/186716585-57a884a4-b2db-4a5d-94ea-a10c7d51dd65.png"/>



<p><em>Add some relevant screenshots of the application in action.</em></p>

<h2 id="contributing">Contributing</h2>

<p>Contributions are welcome! If you find any bugs or have suggestions for improvements, please open an issue or create a pull request.</p>

<h2 id="license">License</h2>

<p>This project is licensed under the <a href="LICENSE">MIT License</a>.</p>

 
