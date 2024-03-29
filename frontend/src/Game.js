import './Game.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

import Status from './component/Status';


function Game() {

  
    const SentPos = (pos) => {
      // if (Anti === "A") {
      //   console.log("It's A", pos);
      //   axios.post('/shop/buyA', { "p": pos })
      //     .then(response => console.log(response.data));
      // } else if (Anti === "B") {
      //   console.log("It's B", pos);
      //   axios.post('/shop/buyB', { "p": pos })
      //     .then(response => console.log(response.data));
      // } else if (Anti === "C") {
      //   console.log("It's C", pos);
      //   axios.post('/shop/buyC', { "p": pos })
      //     .then(response => console.log(response.data));
      // }
      console.log("Buy pos", pos);
        axios.post('/shop/buy', { "p": pos })
          .then(response => console.log(response.data));
    }
  
    // const Antibody = (anti) => {
    //   SetAnti(anti);
    //   console.log(anti);
    // }
  
    return (
  
      <div>
        <Field SentPos = {SentPos}>
        </Field>
        <div className = 'Container'>
          <Menu></Menu>

          <Shop ></Shop>
          <Status></Status>

        </div>
  
      </div>
  );
}


export default Game;
