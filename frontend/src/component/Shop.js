import { useEffect, useState } from 'react';
import axios from 'axios';

const Shop = () => {

  const [anti,setAnti] = useState('');

  function sentBuyAnti(){
    fetch('http://localhost:8080/booboo/shop',{
      method: 'POST',
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(anti)
    }).then(()=> {
      console.log(anti)
    })
  }
  // const buyAnti = async (e) => {
  //   e.preventDefault();
  //   await axios({
  //     url: "http://localhost:8080/booboo/shop",
  //     method: "POST",
  //     data: {
  //       antibody : setAnti,
  //     },
  //   }).then(res => {
  //     console.log(res);
  //     setLoggedIn(true);
  //   })
  //     .catch((err) => console.log(err));
  //   };

  return (
    <div className='Shop'>
      <div className='CreditBar'>
        <p className="CreditText">Credit</p>
      </div>

      <div className="px-100">
        <div className='Card'>
          <div className='Name'>
            Antibody A
          </div>
          <img src={require('./image/antibody/antiA.png')} className="antiImg"></img>
          <button className='BuyBtn' onClick={()=>{setAnti("antibodyA")}, {sentBuyAnti}}>Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody B
          </div>
          <img src={require('./image/antibody/antiB.png')} className="antiImg"></img>
          <button className='BuyBtn' onClick={()=>{setAnti("antibodyB")}, {sentBuyAnti}}>Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody C
          </div>
          <img src={require('./image/antibody/antiC.png')} className="antiImg"></img>
          <button className='BuyBtn' onClick={()=>{setAnti("antibodyC")}, {sentBuyAnti}}>Buy</button>
          
        </div>
      </div>
    </div>

  );



}


export default Shop;