import './Game.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

function Game() {

  const [gameover, setGameover] = useState('');
  //const [Pos,setPos] = useState(null);
  const [Anti,SetAnti] = useState(null);
  if (gameover === "Gameover") {
    alert("GameOver");
  }

  // const PositionApp = (pos) =>{
  //   setPos(pos);
  //   // console.log(pos);
  // } 
  const SentAnti = () => {
    SetAnti(Anti);
  }

  const Antibody = (anti) => {
    SetAnti(anti);
    console.log(anti);
  }

  return (

    <div className='background'>
      <Field SentAnti = {Anti}>
        </Field>
      <div className='Container'>
        <Menu></Menu>
        <Shop Antibody = {Antibody} ></Shop>
      </div>

    </div>

  );
}


export default Game;
