import Navbar from './Navbar';
import NameTitle from './NameTitle';
import AboutMe from './AboutMe';
import Projects from './Projects';


function App() {
  return (
    <>
      <div style={{ display: "block" }}>
        <Navbar />
        <NameTitle />
        <AboutMe />
        <Projects/>
      </div>
      
    </>
  );
}

export default App;