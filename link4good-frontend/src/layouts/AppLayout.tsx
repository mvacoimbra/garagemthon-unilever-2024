import { Link, Outlet, useLocation } from 'react-router-dom'
import Alert from '../components/Alert'

export default function AppLayout() {
  const location = useLocation().pathname

  return (
    <section className="relative">
      <div className="drawer lg:drawer-open">
        <input id="my-drawer-2" type="checkbox" className="drawer-toggle" />
        <div className="drawer-content flex flex-col items-center text-black h-full">
          {/* Page content here */}
          <div className="w-full lg:hidden bg-primary justify-end flex-row flex text-xl gap-4 items-start p-4">
            <label htmlFor="my-drawer-2" className=" drawer-button lg:hidden">
              <i className="fa-solid fa-bars text-white" />
            </label>
          </div>
          <Outlet />
        </div>
        <div className="drawer-side">
          <label
            htmlFor="my-drawer-2"
            aria-label="close sidebar"
            className="drawer-overlay"
          />
          <ul className="menu bg-primary text-white max-sm:text-base text-lg min-h-full w-80 max-sm:w-60 p-4">
            {/* Sidebar content here */}
            <li className="pointer-events-none">
              <img
                src="/public/assets/images/logo.png"
                alt="Unicare Logo"
                className="w-full"
              />
            </li>
            <div className="divider divider-secondary" />
            <li
              className={`${location === '/home' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/home"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-house" />
                <span>Início</span>
              </Link>
            </li>

            <li
              className={`${location === '/crud/orders' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/crud/orders"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-people-carry-box" />
                <span>Pedidos</span>
              </Link>
            </li>

            <li
              className={`${location === '/crud/entities' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/crud/entities"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-hands-holding-child" />
                <span>Entidades</span>
              </Link>
            </li>

            <li
              className={`${location === '/crud/carriers' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/crud/carriers"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-truck-moving" />
                <span>Transportadoras</span>
              </Link>
            </li>

            <li
              className={`${location === '/crud/storage' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/crud/storage"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-boxes-stacked" />
                <span>Estoque</span>
              </Link>
            </li>

            <li
              className={`${location === '/track' ? 'bg-secondary' : ''} rounded-lg`}
            >
              <Link
                to="/track"
                className="font-semibold flex flex-row gap-3 items-baseline"
              >
                <i className="fa-solid fa-satellite-dish" />
                <span>Rastreio</span>
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </section>
  )
}
