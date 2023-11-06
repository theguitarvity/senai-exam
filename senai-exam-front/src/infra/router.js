import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import MainNavbar from '../components/MainNavbar';
import CustomerDetails from "../pages/CurtomerDetails";
import Customers from "../pages/Customers";

const Router = () => {
    return (
        <BrowserRouter>
           <MainNavbar />
           <Routes>
               <Route path="/" element={ <Customers /> } />
               <Route path="/customers/:id" element={ <CustomerDetails />} />
           </Routes>
        </BrowserRouter>
    )
}

export default Router