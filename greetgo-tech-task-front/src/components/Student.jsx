
import axios from 'axios';
import {useEffect, useState } from "react";
function Student()
{

    const [id, setId] = useState('');
    const [fullName, setFullName] = useState("");
    const [address, setAddress] = useState("");
    const [phone, setPhone] = useState("");
    const [age, setAge] = useState("");
    const [students, setUsers] = useState([]);


    useEffect(() => {
        (async () => await Load())();
    }, []);
    async function  Load()
    {
        const result = await axios.get(
            "http://localhost:8085/api/v1/student/getall");
        setUsers(result.data);
        console.log(result.data);
    }


    async function save(event)
    {
        event.preventDefault();
        try
        {
            await axios.post("http://localhost:8085/api/v1/student/save",
                {
                    fullName: fullName,
                    address: address,
                    phone: phone,
                    age: age,
                });
            alert("Student Registation Successfully");
            setId("");
            setFullName("");
            setAddress("");
            setPhone("");
            setAge("")
            Load();
        }
        catch(err)
        {
            alert("User Registation Failed");
        }
    }

    async function editStudent(students)
    {
        setFullName(students.fullName);
        setAddress(students.address);
        setAge(students.age);
        setPhone(students.phone);
        setId(students.id);
    }
    async function DeleteStudent(studentid)
    {
        await axios.delete("http://localhost:8085/api/v1/student/delete/" + studentid);
        alert("Student deleted Successfully");
        Load();
    }
    async function update(event)
    {
        event.preventDefault();
        try
        {
            await axios.put("http://localhost:8085/api/v1/student/edit/" + id ,
                {
                    fullName: fullName,
                    address: address,
                    phone: phone,
                    age: age,

                });
            alert("Registation Updateddddd");
            setId("");
            setFullName("");
            setAddress("");
            setPhone("");
            setAge("")
            Load();
        }
        catch(err)
        {
            alert("Student Updateddd Failed");
        }
    }

    return (
        <div>
            <div class="container mt-4" >
                <h1>Student Information: </h1>
                <form>

                    <div class="form-group">
                        <label>Student Name</label>
                        <input  type="text" class="form-control" id="fullName"
                                value={fullName}
                                onChange={(event) =>
                                {
                                    setFullName(event.target.value);
                                }}
                        />
                    </div>


                    <div class="form-group">
                        <label>Student Address</label>
                        <input  type="text" class="form-control" id="address"
                                value={address}
                                onChange={(event) =>
                                {
                                    setAddress(event.target.value);
                                }}
                        />
                    </div>


                    <div class="form-group">
                        <label>Mobile</label>
                        <input type="text" class="form-control" id="phone"
                               value={phone}
                               onChange={(event) =>
                               {
                                   setPhone(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Student Age:</label>
                        <input type="text" className="form-control" id="age"
                               value={age}
                               onChange={(event) => {
                                   setAge(event.target.value);
                               }}
                        />
                    </div>

                    <div>
                        <button   class="btn btn-primary mt-4"  onClick={save}>Register</button>

                        <button   class="btn btn-warning mt-4"  onClick={update}>Update</button>
                    </div>
                </form>

                <br/>
                <table className="table table-dark" align="center">
                    <thead>
                    <tr>
                        <th scope="col">Student Name</th>
                        <th scope="col">Student Address</th>
                        <th scope="col">Student Mobile</th>
                        <th scope="col">Student Age</th>

                        <th scope="col">Option</th>
                    </tr>
                    </thead>
                    {students.map(function fn(student) {
                        return (
                            <tbody>
                            <tr>
                                <td>{student.fullName}</td>
                                <td>{student.address}</td>
                                <td>{student.phone}</td>
                                <td>{student.age}</td>
                                <td>
                                    <button type="button" className="btn btn-warning"
                                            onClick={() => editStudent(student)}>Edit
                                    </button>
                                    <button type="button" className="btn btn-danger"
                                            onClick={() => DeleteStudent(student.id)}>Delete
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        );
                    })}
                </table>
            </div>
        </div>
    );
}

export default Student;