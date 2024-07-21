import { useState } from "react";
import "../App.css";
import Animation from "./Animation";

function Login() {
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    fetch("http://localhost:8080/api/v1/auth/login", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: formData.get("email"),
        password: formData.get("password"),
      }),
    })
      .then((response) => {
        if (!response.ok) throw new Error(response.status);
        else return response.json();
      })
      .then((data) => {
        console.log(data);
        if (data.fieldErrors) {
          data.fieldErrors.forEach((fieldError) => {
            if (fieldError.field === "email") {
              setEmailError(fieldError.message);
            }

            if (fieldError.field === "password") {
              setPasswordError(fieldError.message);
            }
          });
        } else {
          localStorage.setItem("jwt-token", data.access_token);
          setEmail("");
          setPassword("");
          alert("Success !!");
        }
      })
      .catch((err) => err);
  };

  const onEmailFocus = (e) => {
    e.preventDefault();
    setEmailError("");
  };

  const onPasswordFocus = (e) => {
    e.preventDefault();
    setPasswordError("");
  };

  return (
    <div className="App">
      <div className="login-root">
        <div
          className="box-root flex-flex flex-direction--column"
          style={{ minHeight: "100vh", flexGrow: 1 }}
        >
          <Animation></Animation>
          <div
            className="box-root padding-top--24 flex-flex flex-direction--column"
            style={{ flexGrow: 1, zIndex: 9 }}
          >
            <div className="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
              <h1>
                <a
                  href="https://github.com/Abinandan02/movie-booking"
                  rel="dofollow"
                >
                  SilverScreen
                </a>
                <h2 className="text-3xl underline text-blue-100">
                  Login to start booking!
                </h2>
              </h1>
            </div>
            <div className="formbg-outer">
              <div className="formbg">
                <div className="formbg-inner padding-horizontal--48">
                  <span className="padding-bottom--15">
                    Sign in to your account
                  </span>
                  <form
                    id="stripe-login"
                    method="POST"
                    autoComplete="off"
                    onSubmit={onSubmit}
                  >
                    <div className="field padding-bottom--24">
                      <label htmlFor="email">Email</label>
                      <input
                        value={email}
                        type="text"
                        name="email"
                        onFocus={onEmailFocus}
                        onChange={(e) => setEmail(e.target.value)}
                      />
                      {emailError ? (
                        <span style={{ color: "red", fontSize: "12px" }}>
                          {emailError}
                        </span>
                      ) : (
                        ""
                      )}
                    </div>
                    <div className="field padding-bottom--24">
                      <div className="grid--50-50">
                        <label htmlFor="password">Password</label>
                        <div className="reset-pass">
                          <a href="/">Forgot your password?</a>
                        </div>
                      </div>
                      <input
                        value={password}
                        type="password"
                        name="password"
                        onFocus={onPasswordFocus}
                        onChange={(e) => setPassword(e.target.value)}
                      />
                      {passwordError ? (
                        <span style={{ color: "red", fontSize: "12px" }}>
                          {passwordError}
                        </span>
                      ) : (
                        ""
                      )}
                    </div>
                    <div className="field field-checkbox padding-bottom--24 flex-flex align-center">
                      <label htmlFor="checkbox">
                        <input type="checkbox" name="checkbox" /> Stay signed in
                        for a week
                      </label>
                    </div>
                    <div className="field padding-bottom--24">
                      <input type="submit" name="submit" value="Continue" />
                    </div>
                    <div className="field">
                      <a className="ssolink" href="/">
                        Use single sign-on (Google) instead
                      </a>
                    </div>
                  </form>
                </div>
              </div>
              <div className="footer-link padding-top--24">
                <span>
                  Don't have an account? <a href="/">Sign up</a>
                </span>
                <div className="listing padding-top--24 padding-bottom--24 flex-flex center-center">
                  <span>
                    <a href="/">© BookMovies</a>
                  </span>
                  <span>
                    <a href="/">Contact</a>
                  </span>
                  <span>
                    <a href="/">Privacy & terms</a>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
