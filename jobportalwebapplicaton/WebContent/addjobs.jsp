<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Posting Form</title>
    <style>
    
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    background-color: #f4f4f4;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 500px;
    margin: 0 auto;
}

label {
    font-weight: bold;
}

input[type="text"],
input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box; /* Ensure padding and border don't affect the width */
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 15px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
}


input[type="submit"]:hover {
    background-color: #45a049;
}
    
.back {
  position: absolute;
  left: 20px;
  top: 20px;
}

.back .img {
  width: 30px; /* Adjust the width of the image */
  height: auto; /* Maintain aspect ratio */
}

    </style>
</head>
<body>

<h2>Job Posting Form</h2>

<div class="back">
  <a href="admin.jsp">
    <img src="back.png" class="img">
  </a>
</div>

<form action="jobadd" method="post">
    <label for="companyName">Company Name:</label><br>
    <input type="text" id="companyName" name="companyName"><br><br>

    <label for="jobRequirements">Job Requirements:</label><br>
    <input type="text" id="jobRequirements" name="jobRequirements"><br><br>

    <label for="workExperience">Work Experience:</label><br>
    <input type="text" id="workExperience" name="workExperience"><br><br>

   <label for="field">Field:</label><br>
<select id="field" name="field">
    <option value="IT">IT</option>
    <option value="HR">HR</option>
</select><br><br>
    <label for="location">Location:</label><br>
    <input type="text" id="location" name="location"><br><br>

    <label for="vacancies">Vacancies:</label><br>
    <input type="number" id="vacancies" name="vacancies" min="1"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
