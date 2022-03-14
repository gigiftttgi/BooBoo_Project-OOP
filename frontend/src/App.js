import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

function App() {

  const [gameover, setGameover] = useState('');
  if (gameover === "Gameover") {
    alert("GameOver");
  }

  return (

    <div className='MainGame'>

      <div className='container'>
        <Field>
        </Field>
        <div className='selectZone'>
          <Menu>
          </Menu>
          <Shop></Shop>

        </div>


      </div>



    </div>

  );
}


export default App;
