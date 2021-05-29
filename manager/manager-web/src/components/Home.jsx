import React from 'react';
import Navbar from './Navbar';
import Footer from './Footer';

const Home = () => {
  return (
    <>
      <Navbar />
      <div className="container py-4">
        <header className="pb-3 mb-4 border-bottom">
          <h1 className="display-3">CONNECT DATABASE</h1>
        </header>

        <div className="p-5 mb-4 bg-light rounded-3">
          <div className="container-fluid py-5">
            <h1 className="display-5 fw-bold">Create a database connection</h1>
            <p className="col-md-10 fs-4">
              Use the following application to create a database connection. 
            </p>
            <button className="btn btn-secondary btn-lg" type="button">Example button</button>
          </div>
        </div>

        <div className="row align-items-md-stretch">
          <div className="col-md-6">
            <div className="h-100 p-5 text-white bg-dark rounded-3">
              <h2>ORACLE</h2>
              <p>Text.</p>
              <button className="btn btn-outline-light" type="button">Example button</button>
            </div>
          </div>
          <div className="col-md-6">
            <div className="h-100 p-5 bg-light border rounded-3">
              <h2>MSSQL</h2>
              <p>Text.</p>
              <button className="btn btn-outline-secondary" type="button">Example button</button>
            </div>
          </div>
        </div>
      </div>
      <hr />
      <Footer />
    </>
  );
};

export default Home;