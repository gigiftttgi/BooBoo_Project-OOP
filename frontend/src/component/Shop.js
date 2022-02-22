import { useEffect, useState } from 'react';
import axios from 'axios';

const Shop = () => {

  const [money,setMoney] = usestate('');

  useEffect(async () => {
    const money = await axios('http://localhost:8080/booboo/shop/money');
    setMoney(money.data);
  });


  const [anti,setAnti] = useState('');

  function sentBuyAnti(){
    fetch('http://localhost:8080/shop',{
      method: 'POST',
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(anti)
    }).then(()=> {
      console.log(anti)
    })
  }
 

  return (
    <div className='Shop'>
      <div className='CreditBar'>
        <p className="CreditText">Credit {data}</p>
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