<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update your profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; /* Light gray background */
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        color: #007bff; /* Blue color for heading */
        margin-top: 50px;
    }

    form {
        max-width: 500px; /* Set maximum width */
        margin: 0 auto; /* Center the form horizontally */
        padding: 20px;
        background-color: #fff; /* White background */
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add shadow */
    }

    label {
        font-weight: bold;
        margin-bottom: 5px;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc; /* Add border */
        border-radius: 5px;
        box-sizing: border-box;
    }

    button[type="submit"] {
        background-color: #007bff; /* Blue color for button */
        color: #fff; /* White text color */
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    button[type="submit"]:hover {
        background-color: #0056b3; /* Darker blue color on hover */
    }
</style>
</head>
<body>
    <h2>Update Your Profile</h2>
    <form action="updateProfile" method="post">
        <div>
            <label for="linkedin">LinkedIn Profile:</label><br>
            <input type="text" id="linkedin" name="linkedin">
        </div>
        <div>
            <label for="skills">Skills:</label><br>
            <textarea id="skills" name="skills" rows="4" cols="50"></textarea>
        </div>
        <div>
            <label for="certificates">Certificates:</label><br>
            <textarea id="certificates" name="certificates" rows="4" cols="50"></textarea>
        </div>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
