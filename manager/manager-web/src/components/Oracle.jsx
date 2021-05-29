import React, { useState } from 'react';
import axios from 'axios';
import Navbar from './Navbar';
import Footer from './Footer';

const ORACLE_API_BASE_URL = 'http://localhost:8080/v1/manager/oracle';

const Oracle = () => {

    const [message, setMessage] = useState("");

    const [state, setState] = useState({
        user: "",
        password: "",
        databaseName: "",
        serverName: "",
        portNumber: ""
    })

    const handleChange = e => {
        setState({
            ...state,
            [e.target.name]: e.target.value,
        })
    }

    const oracleConnect = async () => {
        const res = await axios.post(ORACLE_API_BASE_URL, state);
        console.log(res.data);
        setMessage(res.data);
    };

    return (
        <>
            <Navbar />
            <div className="container py-4">
                <header className="pb-3 mb-4 border-bottom">
                    <h1 className="display-3">ORACLE DATABASE</h1>
                </header>
                <div className="row g-3 align-items-center">
                    <div className="col-lg-2">
                        <label 
                            htmlFor="user" 
                            className="col-form-label">User
                        </label>
                    </div>
                    <div className="col-auto">
                        <input
                            type="text"
                            id="user"
                            className="form-control"
                            name="user"
                            value={state.user}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <br />
                <div className="row g-3 align-items-center">
                    <div className="col-lg-2">
                        <label 
                            htmlFor="password" 
                            className="col-form-label">Password
                        </label>
                    </div>
                    <div className="col-auto">
                        <input
                            type="text"
                            id="password"
                            className="form-control"
                            name="password"
                            value={state.password}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <br />
                <div className="row g-3 align-items-center">
                    <div className="col-lg-2">
                        <label 
                            htmlFor="databaseName" 
                            className="col-form-label">Database Name
                        </label>
                    </div>
                    <div className="col-auto">
                        <input
                            type="text"
                            id="databaseName"
                            className="form-control"
                            name="databaseName"
                            value={state.databaseName}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <br />
                <div className="row g-3 align-items-center">
                    <div className="col-lg-2">
                        <label 
                            htmlFor="serverName" 
                            className="col-form-label">Server Name
                        </label>
                    </div>
                    <div className="col-auto">
                        <input
                            type="text"
                            id="serverName"
                            className="form-control"
                            name="serverName"
                            value={state.serverName}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <br />
                <div className="row g-3 align-items-center">
                    <div className="col-lg-2">
                        <label
                            htmlFor="portNumber" 
                            className="col-form-label">Port Number
                        </label>
                    </div>
                    <div className="col-auto">
                        <input
                            type="text"
                            id="portNumber"
                            className="form-control"
                            name="portNumber"
                            value={state.portNumber}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <br />
                <button type="button" className="btn btn-dark" onClick={oracleConnect}>
                    Connect
                </button>
                <span className="mx-4">{message}</span>
            </div>
            <hr />
            <Footer />
        </>
    );
};

export default Oracle;
