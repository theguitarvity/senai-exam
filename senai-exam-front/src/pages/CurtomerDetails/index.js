import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import api from "../../services/api";
import customers from "../Customers";
import cpfValidator from "../../utils/cpfValidator";


const CustomerDetails = () => {

    const { id } = useParams()
    const [customer, setCustomer] = useState({})
    const [formData, setFormData] = useState({ name: '', email: '', document: '', address: '', city: ''})
    const [loading, setLoading] = useState(false)
    const [editing, setEditing] = useState(false)
    const [success, setSuccess] = useState(false)
    const [removeLoading, setRemoveLoading] = useState(false)

    const [error, setError] = useState(false)
    const [errorMessage, setErrorMessage] = useState('')
    const retrieveCustomer = () => {
        api.get(`/customer/${id}`).then(({ data } ) => {
            setCustomer(data)
            setFormData(data)
        })
    }

    const feedbackTrigger = (callback) => {
        callback(true)
        setTimeout( () => callback(false), 3000)
    }

    const handleInputChange= (event) => {
        const { name, value } = event.target;
        setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
    }

    const successTrigger = () => {
        setEditing(false)
        setSuccess(true)
        setTimeout( () => setSuccess(false), 3000)
    }

    useEffect(() => {
        retrieveCustomer()
    }, []);

    const handleCustomerUpdate = (event) => {
        setLoading(true)
        event.preventDefault()


        const body = {id: customer.id, ...formData}

        api.put(`/customer/${id}`, body).then(({ data } ) => {
            setLoading(false)
            successTrigger()
            document.location.href = `/customer/${formData.id}`
            retrieveCustomer();
        }).catch(e => {
            setLoading(false)
        })
    }

    return (
        <div className="container mt-4">

            <div className="row ">
                <h2> Informacoes do cliente { customer.name }</h2>

            </div>
            <div className="row justify-content-end">
                <div className="col">
                    <div className="form-check form-switch">
                        <input className="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked={editing} onChange={() => setEditing(!editing)} />
                        <label className="form-check-label" htmlFor="flexSwitchCheckChecked">Habilitar edicao</label>
                    </div>
                </div>

            </div>



            <form>
                <div className="mb-3">
                    <label htmlFor="customer-name" className="col-form-label">Nome:</label>
                    <input
                        type="text"
                        className="form-control"
                        id="customer-name"
                        name="name"
                        disabled={!editing}
                        value={formData.name}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="customer-document" className="col-form-label">Documento(cpf):</label>
                    <input
                        type="text"
                        className="form-control"
                        disabled={!editing}
                        name="document"
                        id="customer-document"
                        value={formData.document || ""}
                        onChange={handleInputChange}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="customer-address" className="col-form-label">Endereço:</label>
                    <input
                        type="text"
                        className="form-control"
                        disabled={!editing}
                        id="customer-address"
                        name="address"
                        value={formData.address || ""}
                        onChange={handleInputChange}
                    />
                </div>
            </form>
            { success ?
                <div className="alert alert-success" role="alert">
                    Cliente alterado com sucesso
                </div> : ''
            }
            { error ?
                <div className="alert alert-danger" role="alert">
                    {errorMessage}
                </div> : ''
            }


            { editing? <button type="button" className="btn btn-primary" onClick={handleCustomerUpdate}> {loading ? <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>: 'Salvar' }</button> : '' }
            <hr className="mt-2 mb-3"/>

            <h3>Produtos do cliente</h3>

        </div>
    )
}

export default CustomerDetails