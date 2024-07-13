import { useParams } from 'react-router-dom'
import OrderListItem from '../components/OrderListItem'
import { match } from 'ts-pattern'

export default function Crud() {
  const { crudId } = useParams()

  function createListItems(amount: number, crudId: string) {
    return Array.from({ length: amount }).map((item, index) => {
      return match(crudId)
        .with('orders', () => {
          return <OrderListItem key={Math.random()} index={index} />
        })
        .otherwise(() => <OrderListItem key={Math.random()} index={index} />)
    })
  }

  function Title() {
    const select = () => {
      switch (crudId) {
        case 'orders':
          return (
            <div className="text-4xl font-semibold flex flex-row gap-4">
              <h1>Pedidos</h1>
              <i className="fa-solid fa-people-carry-box" />
            </div>
          )
        case 'entities':
          return (
            <div className="text-4xl font-semibold flex flex-row gap-4">
              <h1>Entidades</h1>
              <i className="fa-solid fa-hands-holding-child" />
            </div>
          )
        case 'carriers':
          return (
            <div className="text-4xl font-semibold flex flex-row gap-4">
              <h1>Transportadoras</h1>
              <i className="fa-solid fa-truck-moving" />
            </div>
          )
        case 'storage':
          return (
            <div className="text-4xl font-semibold flex flex-row gap-4">
              <h1>Estoque</h1>
              <i className="fa-solid fa-boxes-stacked" />
            </div>
          )
        default:
          return <div />
      }
    }
    return select()
  }

  const data = createListItems(10, crudId || '')

  return (
    <section className="w-full h-screen p-4 lg:p-8  bg-neutral-200 flex flex-col gap-20">
      <Title />
      <ul className="flex flex-col gap-1">{data}</ul>
    </section>
  )
}
