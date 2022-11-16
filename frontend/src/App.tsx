import Header from "./components/NotificationButton/Header"
import SalesCard from "./components/SalesCard"
import '../src/index.css'

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard/>
          </div>
        </section>
      </main>      
    </>
  )
}

export default App
