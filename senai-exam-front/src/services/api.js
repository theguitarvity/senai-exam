import axios from "axios";
import applicationConfig from "../config/applicationConfig";

const api = axios.create({
    baseURL: applicationConfig.BACKEND_URL
})

export default api