# NIcol Yanina Ticona Aduviri
# R.U: 1855987
import random
class Juego:
    def __init__(self, numeroDeVidas):
        self.numeroDeVidas = numeroDeVidas
        self.record = 0
    def reiniciaPartida(self):
        pass
    def actualizaRecord(self):
        self.record = self.record + 1
    def quitaVida(self):
        self.numeroDeVidas = self.numeroDeVidas - 1
        return self.numeroDeVidas > 0
        
class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__(numeroDeVidas)
        self.numeroAAdivinar = 0
    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("************* Adivina un numero entre 0 y 10 *************")
        while True:
            try:
                a = int(input("Ingresa un numero:"))
            except ValueError:
                print("Ingresa un número válido.")
                continue
            if a == self.numeroAAdivinar:
                print("Acertaste!!")
                self.actualizaRecord()
                return
            else:
                tieneVidas = self.quitaVida()
                if tieneVidas:
                    if a < self.numeroAAdivinar:
                        print("El número a adivinar es mayor")
                    else:
                        print("El número a adivinar es menor")
                    print("¡Inténtalo de nuevo!")
                else:
                    print(f"El número correcto era: {self.numeroAAdivinar}")
                    return
    def reiniciaPartida(self):
        print("============ Nueva Partida de Adivinanza ============")

class Aplicacion:
    @staticmethod
    def main():
        juego = JuegoAdivinaNumero(numeroDeVidas=3)
        juego.juega()
        
if __name__ == "__main__":
    Aplicacion.main()
