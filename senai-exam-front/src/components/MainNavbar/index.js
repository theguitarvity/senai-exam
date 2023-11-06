import React from 'react'
import { Link } from 'react-router-dom'

const MainNavbar = () => {
    return (
        // <nav className="navbar navbar-light bg-dark">
        //     <Link to='/' className="navbar-brand text-white">Gerenciador de clientes</Link>
        // </nav>
        <nav className="navbar navbar-expand-lg bg-body-secondary">
            <div className="container-fluid">
                <Link to='/' className="navbar-brand">Gerenciador de clientes</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Link to="/customers" className="nav-link active" aria-current="page" >Clientes</Link>
                        </li>
                        <li className="nav-item">
                            <Link to='/products' className="nav-link" >Produtos</Link>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>


    )
}

export default MainNavbar