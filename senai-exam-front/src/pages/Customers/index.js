import React, {useEffect, useState} from "react";
import api from "../../services/api";
import {Link} from "react-router-dom";
import cpfValidator from "../../utils/cpfValidator";

const Customers = () => {
    const [customers, setCustomers ] = useState([])
    const [formData, setFormData] = useState({ name: '', email: '', document: '', address: ''})
    const [loading, setLoading] = useState(false)
    const [success, setSuccess] = useState(false)
    const [error, setError] = useState(false)
    const [errorMessage, setErrorMessage] = useState('')


    const retrieveCustomerList = () => {
        api.get('/customer').then(({ data } ) => {
            setCustomers(data)
        })
    }

    const handleInputChange= (event) => {
        const { name, value } = event.target;
        setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
    }

    const successTrigger = () => {
        setSuccess(true)
        setTimeout( () => setSuccess(false), 3000)
    }

    const feedbackTrigger = (callback) => {
        callback(true)
        setTimeout( () => callback(false), 3000)
    }

    const handleCustomerCreation = (event) => {
        setLoading(true)
        event.preventDefault()


        api.post('/customer', formData).then(({ data } ) => {
            setLoading(false)
            setFormData({ name: '', email: '', document: '', address: ''})
            successTrigger()
            retrieveCustomerList();
        }).catch(e => {
            setLoading(false)
        })
    }
    useEffect(() => {
        retrieveCustomerList()
    }, []);
    return (
        <div className='container mt-4'>
            <h1>Clientes</h1>

            <div className='customers-container' >
                <table className="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Documento</th>
                        <th scope="col">Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    { customers.map( (customer, index) =>(
                        <tr key={index}>
                            <th scope="row">{index}</th>
                            <td>{customer.name}</td>
                            <td>{customer.email}</td>
                            <td>{customer.document}</td>
                            <td className="p-2">
                                <Link to={`/customers/${customer.document}`} className="btn btn-outline-primary m-2">Ver detalhes</Link>

                            </td>
                        </tr>
                    ))}


                    </tbody>
                </table>
            </div>
            <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewCustomerModal">
                Cadastrar novo cliente
            </button>


            <div className="modal fade" id="addNewCustomerModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id="exampleModalLabel">Cadastrar novo cliente</h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <form>
                                <div className="mb-3">
                                    <label htmlFor="customer-name" className="col-form-label">Nome:</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="customer-name"
                                        name="name"
                                        value={formData.name}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="customer-document" className="col-form-label">Documento(cpf):</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        name="document"
                                        id="customer-document"
                                        value={formData.document || ""}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="mb-3">
                                    <label htmlFor="customer-email" className="col-form-label">E-mail: </label>
                                    <input
                                        type="email"
                                        className="form-control"
                                        id="customer-email"
                                        name="email"
                                        value={formData.email || ""}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="customer-address" className="col-form-label">Endereço:</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="customer-address"
                                        name="address"
                                        value={formData.address || ""}
                                        onChange={handleInputChange}
                                    />
                                </div>
                            </form>
                            { success ?
                                <div className="alert alert-success" role="alert">
                                    Cliente cadastrado com sucesso
                                </div> : ''
                            }
                            { error ?
                                <div className="alert alert-danger" role="alert">
                                    {errorMessage}
                                </div> : ''
                            }

                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            <button type="button" className="btn btn-primary" onClick={handleCustomerCreation}> {loading ? <span className="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>: 'Salvar' }</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Customers