// import React, { Component } from 'react';
// import MenuButton from './Menubutton';


const Menu = () => {

  // function sentPause(state) {
  //   axios.put('/gameState', anti)
  //     .then(response => console.log(response.data));

  // }


    return (
        <div className="Menu">
             <button className='menuBtn'>
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/speedDownBtn.png')}></img> */}
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/speedUpBtn.png')}></img> */}
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./image/plus.png')}></img> */}

            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/ZoomOutBtn.png')}></img> */}
            </button>
        </div>
    );
}


export default Menu;