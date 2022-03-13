import { useEffect, useState } from 'react';
import axios from 'axios';

const Shop = () => {

  const [money, setMoney] = useState('');


  const fetchMoney = async () => {
    try{
      const m = await axios('/shop/money',);
      setMoney(m.data);
      console.log(m.data);
    }catch(err){
      console.error(err.message);
    }
  };

  useEffect(async () => {
    fetchMoney()

    const interval = setInterval(() => {
      fetchMoney()
    }, 1000)
    return () => clearInterval(interval)


  }, []);


  function sentBuyAntiA(anti) {
    axios.post('/shop/buyA', anti)
      .then(response => console.log(response.data));

  }

  function sentBuyAntiB(anti) {
    axios.post('/shop/buyB', anti)
      .then(response => console.log(response.data));

  }

  function sentBuyAntiC(anti) {
    axios.post('/shop/buyC', anti)
      .then(response => console.log(response.data));

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
            onClick={() => { sentBuyAntiA("antiA"); }}
          >Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody B
          </div>
          <img src={require('./image/antibody/antiB.png')} className="antiImg"></img>
          <button className='BuyBtn'
            onClick={() => { sentBuyAntiB("antiB");  }}
          >Buy</button>

        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody C
          </div>
          <img src={require('./image/antibody/antiC.png')} className="antiImg"></img>
          <button className='BuyBtn'
            onClick={() => { sentBuyAntiC("antiC");  }}
          >Buy</button>

        </div>
      </div>
    </div>

  );

}


export default Shop;