import './App.css';
import Field from './component/Field';
import Menu from './component/Menu';
import Shop from './component/Shop';

function App() {
  return (
    <div className='MainGame'>
      <Menu>
      </Menu>



      <div className='container'>
        <Field>
        </Field>
        <Shop></Shop>
      </div>


    </div>

  );
}


export default App;
