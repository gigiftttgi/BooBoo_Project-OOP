import { useEffect, useState } from 'react';
import axios from 'axios';

const Shop = () => {

  const [money, setMoney] = useState('');

  useEffect(async () => {
    const m = await axios('/shop/money',);
    setMoney(m.data);
    console.log(m.data);

  }, []);

  const [anti, setAnti] = useState('');

  // function sendBuy(){
  //   axios.post('http://localhost:8080/shop/buy')
  //   .the
  // }



  function sentBuyAnti(anti) {
    axios.post('/shop/buy',anti)
    .then(response => setAnti(response.data.anti))

  }


  return (
    <div className='Shop'>
      <div className='CreditBar'>
        <p className="CreditText">Credit: {money}</p>
      </div>

      <div className="px-100">
        <div className='Card'>
          <div className='Name'>
            Antibody A
          </div>
          <img src={require('./image/antibody/antiA.png')} className="antiImg"></img>
          <button className='BuyBtn'
          //  onClick={() => { sentBuyAnti(setAnti("antibodyA")) }}
           >Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody B
          </div>
          <img src={require('./image/antibody/antiB.png')} className="antiImg"></img>
          <button className='BuyBtn' 
          // onClick={() => { setAnti("antibodyB") }, { sentBuyAnti }}
          >Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody C
          </div>
          <img src={require('./image/antibody/antiC.png')} className="antiImg"></img>
          <button className='BuyBtn' 
          // onClick={() => { setAnti("antibodyC") }, { sentBuyAnti }}
          >Buy</button>

        </div>
      </div>
    </div>

  );

}


export default Shop;