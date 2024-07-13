import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './pages/Login'
import Dashboard from './pages/Dashboard'
import AppLayout from './layouts/AppLayout'
import Crud from './pages/Crud'
import Track from './pages/Track'

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} index />
        <Route element={<AppLayout />}>
          <Route path="/home" element={<Dashboard />} index />
          <Route path="/crud">
            <Route path=":crudId" element={<Crud />} />
          </Route>
          <Route path="/track" element={<Track />} index />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}
