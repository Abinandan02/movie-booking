import React, { Component } from "react";
import { Navigate } from 'react-router-dom';
import { connect } from "react-redux";
import { login } from "../actions/auth";

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
            this.setState({
                emailError: fieldError.message
            });
          }
  
          if(fieldError.field === 'password'){
            this.setState({
                passwordError: fieldError.message
            });
          }
        });
      } else {
        alert("Success !!");
      }
    })
    .catch((err) => err)
}

const required = (value) => {
    if (!value) {
      return (
        <div className="alert alert-danger" role="alert">
          This field is required!
        </div>
      );
    }
  };

  class Login extends Component {
    constructor(props) {
      super(props);
      this.handleLogin = this.handleLogin.bind(this);
      this.onChangeEmail = this.onChangeEmail.bind(this);
      this.onChangePassword = this.onChangePassword.bind(this);
      this.state = {
        email: "",
        password: "",
        loading: false,
        emailError: "",
        passwordError: "",
      };
    }
  
    onChangeEmail(e) {
      this.setState({
        email: e.target.value,
      });
    }
  
    onChangePassword(e) {
      this.setState({
        password: e.target.value,
      });
    }
  
    handleLogin(e) {
      e.preventDefault();
  
      this.setState({
        loading: true,
      });
  
      this.form.validateAll();
  
      const { dispatch, history } = this.props;
  
      if (this.checkBtn.context._errors.length === 0) {
        dispatch(login(this.state.email, this.state.password))
          .then(() => {
            history.push("/profile");
            window.location.reload();
          })
          .catch(() => {
            this.setState({
              loading: false
            });
          });
      } else {
        this.setState({
          loading: false,
        });
      }
    }
  
    render() {
      const { isLoggedIn, message } = this.props;
      if (isLoggedIn) {
        return <Navigate to="/profile" />;
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
              <form id="stripe-login" method="POST" onSubmit={onSubmit} ref={(c) => {
              this.form = c;
            }}>
                <div class="field padding-bottom--24">
                  <label for="email">Email</label>
                  <input type="email" name="email" value={this.state.email} onChange={this.onChangeEmail} validations={[required]}/>
                  {
                    this.state.emailError ? <span style={{ color: 'red', fontSize: '12px'}}>{this.state.emailError}</span> : ''
                  }
                </div>
                <div class="field padding-bottom--24">
                  <div class="grid--50-50">
                    <label for="password">Password</label>
                    <div class="reset-pass">
                      <a href="#">Forgot your password?</a>
                    </div>
                  </div>
                  <input type="password" name="password" value={this.state.password}
                    onChange={this.onChangePassword}
                    validations={[required]}/>
                  {
                    this.state.passwordError ? <span style={{ color: 'red', fontSize: '12px'}}>{this.state.passwordError}</span> : ''
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
  }
  
  function mapStateToProps(state) {
    const { isLoggedIn } = state.auth;
    const { message } = state.message;
    return {
      isLoggedIn,
      message
    };
  }
  
  export default connect(mapStateToProps)(Login);