import { useState } from "react";
import { ValidateEmail } from "../../src/utils";
import "./register.css";
import { useNavigate } from "react-router-dom";

const PasswordErrorMessage = () => {
  return (
    <p className="FieldError">Password should have at least 8 characters</p>
  );
};

const Register = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState({
    value: "",
    isTouched: false,
  });
  const navigate = useNavigate();

  const getIsFormValid = () => {
    return firstName && ValidateEmail(email) && password.value.length >= 8;
  };

  const clearForm = () => {
    setFirstName("");
    setLastName("");
    setPhoneNumber("");
    setEmail("");
    setPassword({
      value: "",
      isTouched: false,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:8080/api/v1/auth/register", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password.value, // Use the value property
        phoneNumber: phoneNumber,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(response.status);
        } else return response.json();
      })
      .then((data) => {
        console.log(data);
        localStorage.setItem("jwt-token", data.access_token);
        localStorage.setItem("authenticated", "true");
        clearForm();
        alert("Account created!");
        navigate("/dashboard");
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <div className="register">
      <form onSubmit={handleSubmit}>
        <fieldset>
          <h2>Sign Up</h2>
          <div className="Field">
            <label>
              First name <sup>*</sup>
            </label>
            <input
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              placeholder="First name"
            />
          </div>
          <div className="Field">
            <label>Last name</label>
            <input
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              placeholder="Last name"
            />
          </div>
          <div className="Field">
            <label>Phone Number</label>
            <input
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              placeholder="Phone number" // Updated placeholder
            />
          </div>
          <div className="Field">
            <label>
              Email address <sup>*</sup>
            </label>
            <input
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Email address"
            />
          </div>
          <div className="Field">
            <label>
              Password <sup>*</sup>
            </label>
            <input
              value={password.value}
              type="password"
              onChange={(e) =>
                setPassword({ ...password, value: e.target.value })
              }
              onBlur={() => setPassword({ ...password, isTouched: true })}
              placeholder="Password"
            />
            {password.isTouched && password.value.length < 8 ? (
              <PasswordErrorMessage />
            ) : null}
          </div>
          <button type="submit" disabled={!getIsFormValid()}>
            Create account
          </button>
        </fieldset>
      </form>
    </div>
  );
};

export default Register;
