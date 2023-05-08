import {  useState } from "react";
import { useNavigate } from 'react-router-dom';

import axios from "axios";

function Register() {
    const [fullName, setFullName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8085/api/v1/user/save", {
                fullName: fullName,
                email: email,
                password: password,
            });
            alert("Employee Registation Successfully");
            navigate('/');

        } catch (err) {
            alert(err);
        }
    }

    async function LoginPage()
    {
        navigate('/');
    }

    return (
        <div>
            <div class="container mt-4" >
                <div class="card">
                    <h1>Student Registation</h1>

                    <form>
                        <div class="form-group">
                            <label>Employee name</label>
                            <input type="text"  class="form-control" id="fullName" placeholder="Enter Name"

                                   value={fullName}
                                   onChange={(event) => {
                                       setFullName(event.target.value);
                                   }}
                            />

                        </div>

                        <div class="form-group">
                            <label>email</label>
                            <input type="email"  class="form-control" id="email" placeholder="Enter Email"

                                   value={email}
                                   onChange={(event) => {
                                       setEmail(event.target.value);
                                   }}

                            />
                        </div>

                        <div class="form-group">
                            <label>password</label>
                            <input type="password"  class="form-control" id="password" placeholder="Enter password"

                                   value={password}
                                   onChange={(event) => {
                                       setPassword(event.target.value);
                                   }}

                            />
                        </div>

                        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
                        <a className="btn btn-primary mt-4"  onClick={LoginPage}>Login</a>

                    </form>
                </div>
            </div>
        </div>
    );
}

export default Register;
