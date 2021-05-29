import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faDatabase } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <a className="navbar-brand" href="/">MANAGER DATABASES</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse " id="navbar">
          <div className="navbar-nav ms-auto">
            <Link to="/oracle" className="nav-link">
              <FontAwesomeIcon icon={faDatabase} /> ORACLE&nbsp;&nbsp;
            </Link>
            <Link to="/" className="nav-link">
              <FontAwesomeIcon icon={faDatabase} /> MSSQL&nbsp;&nbsp;
            </Link>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
