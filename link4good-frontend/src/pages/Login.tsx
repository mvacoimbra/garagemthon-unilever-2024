import { type SubmitHandler, useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'

type FormData = {
  email: string
  password: string
}

export default function Login() {
  const { register, handleSubmit } = useForm<FormData>()

  const navigate = useNavigate()

  const onSubmit: SubmitHandler<FormData> = (data) => {
    console.log(data)
    if (data.email === 'marcos@unilever.com.br') {
      navigate('/home')
    }
  }

  return (
    <section className="flex flex-col gap-9 text-black justify-center items-center bg-[url('/public/assets/images/illustration-bg.jpg')] bg-cover bg-center w-screen h-screen">
      <img
        src="/public/assets/images/logo-color.png"
        alt="Unicare Logo"
        className="w-96"
      />
      <div className="card bg-neutral-200 w-96 shadow-xl">
        <div className="card-body">
          <h1 className="card-title">Login</h1>
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="flex flex-col gap-2"
          >
            <label className="form-control w-full max-w-xs">
              <div className="label">
                <span className="label-text text-black">Email:</span>
              </div>
              <input
                type="email"
                placeholder="email@dominio.com"
                className="input input-bordered w-full max-w-xs"
                {...register('email', { required: true })}
              />
            </label>

            <label className="form-control w-full max-w-xs">
              <div className="label">
                <span className="label-text text-black">Senha:</span>
              </div>
              <input
                type="password"
                placeholder="••••••"
                className="input input-bordered w-full max-w-xs"
                {...register('password', { required: true })}
              />
            </label>

            <div className="card-actions justify-center">
              <button type="submit" className="btn btn-primary">
                Conectar
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>
  )
}
