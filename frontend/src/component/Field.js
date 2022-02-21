import React from 'react';
import APIService from './APIService';

export default class Field extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            cells: [],
            DataisLoaded: false

        }
    }

    componentDidMount() {
        // APIService.getPos().then((data) => {
        //     this.setState({ cells: data })
        //     console.log(this.state.data)
        // })
        //     .catch(function (ex) {
        //         console.log('Response parsing failed. Error: ', ex);
        //     });;
        fetch(
            "http://localhost:8080/test")
                        .then((res) => res.json())
                        .then((json) => {
                            this.setState({
                                items: json,
                                DataisLoaded: true
                            });
                        })
    }


    render() {
        const{DataisLoaded, cells} = this.state;
        if(!DataisLoaded) return<div> Waiting </div>

        return(
            <div className='Field'>
                {cells.map((cell)=>(
                    <head>
                        <p>{cell.x}</p>
                        <p>{cell.y}</p>
                    </head>

                ))
                

                }
            </div>
        )

    }


}


// export default Field;