import './App.css';
import { useState } from "react";

function App() {

  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');

  const onSubmit = (e) => {
    e.preventDefault();
  
    const formData = new FormData(e.target);
  
    fetch("http://localhost:8080/login", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: formData.get('email'),
        password: formData.get('password'),
      }),
    })
    .then((response) => response.json())
    .then((data) => {
      if(data.fieldErrors) {
        data.fieldErrors.forEach(fieldError => {
          if(fieldError.field === 'email'){
            setEmailError(fieldError.message);
          }
  
          if(fieldError.field === 'password'){
            setPasswordError(fieldError.message);
          }
        });
      } else {
        alert("Success !!");
      }
    })
    .catch((err) => err)
  }

  return (
    <div class="login-root">
    <div class="box-root flex-flex flex-direction--column"  style={{ minHeight: "100vh", flexGrow: 1 }}>
      <div class="loginbackground box-background--white padding-top--64">
        <div class="loginbackground-gridContainer">
          <div class="box-root flex-flex" style={{ gridArea: "top / start / 8 / end" }}>
            <div class="box-root" style={{
                    backgroundImage:
                      "linear-gradient(white 0%, rgb(247, 250, 252) 33%)",
                    flexGrow: 1,
                  }}>
            </div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "4 / 2 / auto / 5" }}>
            <div class="box-root box-divider--light-all-2 animationLeftRight tans3s" style={{ flexGrow: "1" }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "6 / start / auto / 2" }}>
            <div class="box-root box-background--blue800" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "7 / start / auto / 4" }}>
            <div class="box-root box-background--blue animationLeftRight" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "8 / 4 / auto / 6" }}>
            <div class="box-root box-background--gray100 animationLeftRight tans3s" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "2 / 15 / auto / end" }}>
            <div class="box-root box-background--cyan200 animationRightLeft tans4s" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "3 / 14 / auto / end" }}>
            <div class="box-root box-background--blue animationRightLeft" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "4 / 17 / auto / 20" }}>
            <div class="box-root box-background--gray100 animationRightLeft tans4s" style={{ flexGrow: 1 }}></div>
          </div>
          <div class="box-root flex-flex" style={{ gridArea: "5 / 14 / auto / 17" }}>
            <div class="box-root box-divider--light-all-2 animationRightLeft tans3s" style={{ flexGrow: 1 }}></div>
          </div>
        </div>
        <div class="popcorn-image" style={{textAlign: "right"}}>
          <img src="../popcorn2.jpg" class="img-fluid" alt="project image"/>
        </div>
      </div>
      <div class="box-root padding-top--24 flex-flex flex-direction--column" style={{ flexGrow: 1, zIndex: 9 }}>
        <div class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
          <h1><a href="http://blog.stackfindover.com/" rel="dofollow">Cinematease</a></h1>
        </div>
        <div class="formbg-outer">
          <div class="formbg">
            <div class="formbg-inner padding-horizontal--48">
              <span class="padding-bottom--15">Sign in to your account</span>
              <form id="stripe-login" method="POST" onSubmit={onSubmit}>
                <div class="field padding-bottom--24">
                  <label for="email">Email</label>
                  <input type="email" name="email"/>
                  {
                    emailError ? <span style={{ color: 'red', fontSize: '12px'}}>{emailError}</span> : ''
                  }
                </div>
                <div class="field padding-bottom--24">
                  <div class="grid--50-50">
                    <label for="password">Password</label>
                    <div class="reset-pass">
                      <a href="#">Forgot your password?</a>
                    </div>
                  </div>
                  <input type="password" name="password"/>
                  {
                    passwordError ? <span style={{ color: 'red', fontSize: '12px'}}>{passwordError}</span> : ''
                  }
                </div>
                <div class="field field-checkbox padding-bottom--24 flex-flex align-center">
                  <label for="checkbox">
                    <input type="checkbox" name="checkbox"/> Stay signed in for a week
                  </label>
                </div>
                <div class="field padding-bottom--24">
                  <input type="submit" name="submit" value="Continue"/>
                </div>
                <div class="field">
                  <a class="ssolink" href="#">Use single sign-on (Google) instead</a>
                </div>
              </form>
            </div>
          </div>
          <div class="footer-link padding-top--24">
            <span>Don't have an account? <a href="">Sign up</a></span>
            <div class="listing padding-top--24 padding-bottom--24 flex-flex center-center">
              <span><a href="#">© Cinematease</a></span>
              <span><a href="#">Contact</a></span>
              <span><a href="#">Privacy & terms</a></span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  );
}

export default App;
