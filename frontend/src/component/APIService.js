const POSITION_API = 'http://localhost:8080/test';
class APIService {    
    getPos(){
        return fetch(POSITION_API,{ 
            method: 'get',
                headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json',
                },
                'credentials': 'same-origin'
        })
        .then(res => res.json());        
    }

}

export default new APIService();