import axios from "axios";

const API_URL = "http://localhost:8081/parks";

const parkService = {
    getAllParks() {
        return axios.get(API_URL);
    },
    addPark(park) {
        return axios.post(API_URL, park);
    },
    updatePark(park) {
        return axios.put(API_URL, park);
    },
    deletePark(id) {
        return axios.delete(`${API_URL}/${id}`);
    },
};

export default parkService;
